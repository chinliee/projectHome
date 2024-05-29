
  const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            product: [],
            orderProductDtoliList:[],

            quantity:null,
            memberId:45461,
        }
    },
    computed: {
        canCreateOrder() {
            return this.orderProductDtoliList.length > 0;
            },
            totalPrice() {
        return this.orderProductDtoliList.reduce((total, item) => {
            const product = this.product.find(p => p.productId === item.productId);
            return total + (product ? product.price * item.quantity : 0);
        }, 0);
    },

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

            axios.post("http://localhost:8080/product/findCustomer" , { params: data }).then((response) => {
                this.product = response.data;

            }).catch(function (error) {
                console.log(error);
            })

        },
        callInsert: function () {
            let data = {
                memberId: this.memberId,
                orderProductDtoliList:this.orderProductDtoliList
                };
            console.log(data);
            axios.post("http://localhost:8080/create", data)
                .then((response) => {
                    console.log("OK");
                    
                    this.callAllFind();
                    
                    this.orderProductDtoliList = [];
                    
                    this.product.forEach(product => {
                        product.selectedQuantity = 1;
                        product.isSelected = false;
                    });
                })
            .catch(function(error) {
                console.log(error);
                console.log(data);
            });
        },
        updateOrderProductList(product, checked) {
            if (checked) {
                product.selectedQuantity = 1;
                product.isSelected = true; 
                this.orderProductDtoliList.push({ productId: product.productId, quantity: product.selectedQuantity });
            } else {
                product.isSelected = false; 
                const index = this.orderProductDtoliList.findIndex(item => item.productId === product.productId);
                if (index !== -1) {
                    this.orderProductDtoliList.splice(index, 1);
                }
            }
        },
        checkQuantity(product) {

            product.selectedQuantity = product.selectedQuantity.toString().replace(/[-+]{1,}/g, '');
            // 不超過 quantity
            if (product.selectedQuantity > product.quantity) {
                product.selectedQuantity = product.quantity;
            }
            // 更新 orderProductDtoliList 
            const index = this.orderProductDtoliList.findIndex(item => item.productId === product.productId);
            if (index !== -1) {
                this.orderProductDtoliList[index].quantity = product.selectedQuantity;
            }
        },

            }
        });
const vm = app.mount("#aaa");
vm.callAllFind();

