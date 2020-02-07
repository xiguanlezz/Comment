function search(currentPage) {
    // $("#mainForm").attr("method","GET");
    // $("#mainForm").attr("action", $("#basePath").val() + "/business");
    $("#currentPage").attr("value", currentPage);
    $("#mainForm").submit();

}