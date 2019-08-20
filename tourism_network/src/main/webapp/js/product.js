new Vue({
    el:"#app",
    data:{
        productList:[]
    },
    methods:{
        findAll:function () {
            var _this = this;
            axios.get("/product/findAll")
                .then(function (response) {
                    _this.productList = response.data;
                })
                .catch(function (reason) {
                    console.log(reason);
                })
        }
    },
    created:function () {
        this.findAll();
    }
})