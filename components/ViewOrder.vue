<template>
<div id="viewOrderList">
    <table>
  <tr>
    <th>Order Id</th>
    <th>Medicine Id</th>
    <th>Medicine Quantity</th>
    <th>Order Date</th>
    <th>Total Amount</th>
  </tr>
  <tr v-for="order in getOrderList" :key="order.id">
    <td>{{order.orderId}}</td>
    <td>{{order.medicineId}}</td>
    <td>{{order.medicineQuantity}}</td>
    <td>{{order.orderDate}}</td>
    <td>{{order.totalAmount}}</td>
  </tr>
</table>
</div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getOrderList'])
  }
}
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
