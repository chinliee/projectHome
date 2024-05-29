const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            product: [],
            productId:null,
            productName:null,
            price:null,
            quantity:null

        }
    },
    methods: {
        callAllFind: function () {
            let data = {
                start: 0,
                rows: 100,
            };
            // Swal.fire({
            //     text: "Loading......",
            //     allowOutsideClick: false,
            //     showConfirmButton: false,
            // })
            // setTimeout(function () {
            //     Swal.close()
            // }, 1000);

            axios.post("http://localhost:8080/product/find" , { params: data }).then((response) => {
                this.product = response.data;

            }).catch(function (error) {
                console.log(error);
            })
        },

        callInsert: function () {
   
            let xsProductId = this.productId.replace(/<script>|<\/script>/gi, '');
            let xsProductName = this.productName.replace(/<script>|<\/script>/gi, '');
            let xsPrice = this.price.replace(/<script>|<\/script>/gi, '');
            let xsQuantity = this.quantity.replace(/<script>|<\/script>/gi, '');     

            let data = {
            productId:this.xsProductId,
            productName:this.xsProductName,
            price:this.xsPrice,   
            quantity:this.xsQuantity
            };
            console.log(data);
            axios.post("http://localhost:8080/product/insert", data).then((response) => {
                console.log("OK");
                vm.callAllFind();

            })
                .catch(function (error) {
                    console.log(error);
                    console.log(data);
                })
        },
    
    }
});
const vm = app.mount("#aaa");
vm.callAllFind();
