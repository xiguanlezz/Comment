package com.cj.controller.interceptor;

import com.cj.entity.BaseBean;
import com.cj.entity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Properties;

//拦截实现StatementHandler接口的类中的prepare方法
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //配置文件的id
        String id = mappedStatement.getId();
        if (id.endsWith("ByPage")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            //原始的SQL语句
            String sql = boundSql.getSql();
            //获取SQL语句中的参数
            BaseBean bean = (BaseBean) boundSql.getParameterObject();
            //将当前SQL作为子查询, 并且需要取别名
            String countSql = "select count(*) from(" + sql + ")t";
            //根据注解获取对象
            Connection conn = (Connection) invocation.getArgs()[0];
            PreparedStatement ps = conn.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(ps);
            ResultSet rs = ps.executeQuery();
            Page page = bean.getPage();
            if (rs.next()) {
                //给Page对象赋值
                page.setTotalCount(rs.getInt(1));
//                bean.setPage(page);
            }
//            System.out.println(page);
            String pageSql = sql + " limit " + (page.getCurrentPage() - 1) * page.getPageSize() + "," + page.getPageSize();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        //如果是注解对应的对象就包装成代理对象,进而执行intercept方法; 否则直接放行
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
