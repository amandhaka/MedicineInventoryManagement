<template>
  <div class="order-class" id="createOrderDiv">
        <div class="form-container">
        <div>
             <h2>Generate New Order</h2>
            <div class="flex space-evenly">

                <div>
                    <label for="medicineQuantity"><b>Medicine Quantity</b></label>
                    <input type="text" placeholder="Medicine Quantity" v-model="medicineQuantity" required>
                </div>
                <div>
                    <label for="medicineId"><b>Medicine Id</b></label>
                    <input type="text" placeholder="medicineId" v-model="medicineId" required>
                </div>

            </div>

            <div class="flex space-evenly">
                <div>
                    <label for="orderDate"><b>Order Date</b></label>
                    <input type="date" placeholder="Order Date" v-model="orderDate" required>
                </div>

                <div>
                    <label for="orderId"><b>Order Id</b></label>
                    <input type="text" placeholder="Enter order Id" v-model="orderId" required>
                </div>
            </div>

            <div class="flex space-evenly">
                <div>
                    <label for="totalAmount"><b>Total Amount</b></label>
                    <input type="text" placeholder="Enter total Amount" v-model="totalAmount" required>
                </div>
            </div>
            <button type="submit" class="btn_createOrder" @click="oncreateOrder">Create Order</button>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      medicineId: '',
      orderDate: '',
      orderId: '',
      medicineQuantity: '',
      totalAmount: ''
    }
  },
  methods: {
    oncreateOrder () {
      console.log('category id', this.category_id)
      this.$store.dispatch('setNewOrderObjAction', {
        medicineId: parseInt(this.medicineId),
        orderDate: this.orderDate,
        orderId: this.orderId,
        medicineQuantity: parseInt(this.medicineQuantity),
        totalAmount: this.totalAmount
      })
    }
  }

}
</script>

<style scoped>
.order-class {
  border: 3px solid #e45826;
  display: flex;
  justify-content: center;
  align-items: center;
  vertical-align: middle;
  margin: auto;
  width: 70%;
}
h2 {
    text-align: center;
}

.form-container {
    padding: 30px;
    width: 580px;
}

.flex {
    display: flex;
}

.space-evenly {
    justify-content: space-between;
}

label {
    margin-right: 10px;
    margin-top:20px;
}
button {
    margin-top: 10px;
    margin-left: 150px;
}
</style>
