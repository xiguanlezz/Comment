<%@tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@attribute type="com.cj.entity.Page" name="page" required="true" %>
<%@attribute type="java.lang.String" name="methodName" required="true" %>
<script type="text/javascript">
    function transCurrentPage(cp, max) {
        // console.log(cp)
        if (parseInt(cp) < 1) {
            cp = 1;
        } else if (parseInt(cp) > parseInt(max)) {
            // alert(cp)
            cp = max;
        }
        eval("${methodName}(cp)");
    }
</script>
<div class="page fix">
    <a href="javascript:transCurrentPage('1','${page.totalPage}');" class="first">首页</a>
    <a href="javascript:transCurrentPage('${page.currentPage - 1}','${page.totalPage}');"
       class="pre">上一页</a>
    当前第<span>${page.currentPage}/${page.totalPage}</span>页
    <a href="javascript:transCurrentPage('${page.currentPage + 1}','${page.totalPage}');"
       class="next">下一页</a>
    <a href="javascript:transCurrentPage('${page.totalPage}','${page.totalPage}');" class="last">末页</a>
    跳至 &nbsp;<input id="currentPageText" name="currentPage" value="1" class="allInput w28" type="text"/>&nbsp;页
    &nbsp;
    <a href="javascript:transCurrentPage($('#currentPageText').val(),'${page.totalPage}');" class="go">GO</a>
</div>