<template>
  <div>
    <div>
      <navbar />
    </div>
    <div class="btn-order">
      <button class="big-button" v-on:click="createOrder()" @click="toggleCreateOrderBtn">Create Order</button>
      <create-order v-show="visible4"/>
      <button class="big-button" v-on:click="deleteOrder()" @click="toggleDeleteOrderBtn">Delete Order</button>
      <delete-order v-show="visible5"/>
      <button class="big-button" v-on:click="viewOrderList()" @click="toggleViewOrderBtn">View Order List</button>
      <view-order v-show="visible6"/>
      <button class="big-button" v-on:click="viewMedicineToOrder()" @click="toggleViewMedicineToOrderBtn">View Medicine To Order</button>
      <view-medicine-to-order v-show="visible7"/>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/NavBar.vue'
import createOrder from '@/components/createOrder.vue'
import deleteOrder from '@/components/DeleteOrder.vue'
import ViewOrder from '@/components/ViewOrder.vue'
import ViewMedicineToOrder from '@/components/ViewMedicineToOrder.vue'

export default {
  components: { createOrder, Navbar, deleteOrder, ViewOrder, ViewMedicineToOrder },
  data () {
    return {
      visible4: false,
      visible5: false,
      visible6: false,
      visible7: false
    }
  },
  methods: {
    viewMedicineToOrder () {
      document.getElementById('ViewMedicineToOrder_Div').style.display = 'block'
      this.$store.dispatch('setMedicineToOrderAction')
    },
    closeForm_viewMedicineToOrder () {
      document.getElementById('ViewMedicineToOrder_Div').style.display = 'none'
    },
    toggleViewMedicineToOrderBtn () {
      if (this.visible7 === true) this.visible7 = false
      else this.visible7 = true
    },
    // ======
    viewOrderList () {
      document.getElementById('viewOrderList').style.display = 'block'
      this.$store.dispatch('setMedicineOrderAction')
    },
    closeForm_viewOrder () {
      document.getElementById('viewOrderList').style.display = 'none'
    },
    toggleViewOrderBtn () {
      if (this.visible6 === true) this.visible6 = false
      else this.visible6 = true
    },
    // ======
    createOrder () {
      document.getElementById('createOrderDiv').style.display = 'block'
    },
    closeForm_createOrder () {
      document.getElementById('createOrderDiv').style.display = 'none'
    },
    toggleCreateOrderBtn () {
      if (this.visible4 === true) this.visible4 = false
      else this.visible4 = true
    },
    // =======
    deleteOrder () {
      document.getElementById('DeleteOrderDiv').style.display = 'block'
    },
    closeForm_deleteOrder () {
      document.getElementById('DeleteOrderDiv').style.display = 'none'
    },
    toggleDeleteOrderBtn () {
      if (this.visible5 === true) this.visible5 = false
      else this.visible5 = true
    }
  },
  created () {
    const jwt = localStorage.getItem('JWT_TOKEN')
    if (jwt === null) {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.big-button {
  padding: 15px 25px;
  font-size: 24px;
  width: 100%;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: rgb(13, 188, 194);
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
  display: block;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
   background-color:#89CFF0;
  -webkit-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
-moz-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
}
.btn_login button{
    font-size: 10px !important;
    width: 50% !important;
}

.btn_close button{
    font-size: 10px !important;
    width: 50% !important;

}

.big-button button:hover {
  background-color: #3e8e41;
}
.big-button button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.btn-order{
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: 5%;
    margin-right: 5%;
}
</style>
