const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            orderDetail: [],
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

            axios.post("http://localhost:8080/orderDetail" , { params: data }).then((response) => {
                this.orderDetail = response.data;

            }).catch(function (error) {
                console.log(error);
            })
        },         
    }
});
const vm = app.mount("#aaa");
vm.callAllFind();
