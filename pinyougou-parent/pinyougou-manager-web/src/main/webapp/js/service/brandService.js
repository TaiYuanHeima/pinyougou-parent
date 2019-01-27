app.service('brandService',function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../brand/findAll.do');
    }
    this.findOne=function (id) {
        return $http.get('../brand/findOne.do?id='+id);
    }
    this.findPage=function (page,rows) {
        return $http.get('../brand/findPage.do?page=' + page + '&rows=' + rows);
    }
    this.dele=function (selectIds) {
        return $http.get('../brand/delete.do?ids='+selectIds);
    }
    this.search=function (page,rows,searchEntity) {
        return $http.post('../brand/search.do?page='+page+"&rows="+rows, searchEntity);
    }
    this.save=function (methodName,entity) {
        return $http.post('../brand/'+ methodName +'.do',entity );
    }
    this.selectOptionList=function () {
        return $http.get('../brand/selectOptionList.do');
    }
});