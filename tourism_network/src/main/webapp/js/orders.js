orders = ${requestScope.orders};
new Vue({
    el:"#app",
    data:{
        order:{}
    },
    methods:{
        findAll:function () {
            this.order = orders;
        }
    },
    created:function () {
        this.findAll();
        console.log(this.order)
    }
})