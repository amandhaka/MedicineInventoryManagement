<template>
<div id="ViewMedicineToOrder_Div">
<table>
  <tr>
    <th>Medicine Id</th>
    <th>Medicine Name</th>
    <th>Category Id</th>
    <th>Category Name</th>
    <th>Manufacturer</th>
    <th>Formula</th>
    <th>Dosage</th>
    <th>MFD Date</th>
    <th>EXP Date</th>
    <th>Quantity</th>
    <th>Cost</th>
    <th>Total Quantity</th>
  </tr>
  <tr v-for="order in getMedicineToOrderList" :key="order.id">
    <td>{{order.medicineId}}</td>
    <td>{{order.medicineName}}</td>
    <td>{{order.categoryId}}</td>
    <td>{{order.categoryName}}</td>
    <td>{{order.manufacturer}}</td>
    <td>{{order.formula}}</td>
    <td>{{order.dosage}}</td>
    <td>{{order.mfdDate.substring(0,10)}}</td>
    <td>{{order.expiryDate.substring(0,10)}}</td>
    <td>{{order.quantity}} {{order.unit}}</td>
    <td>{{order.costPerUnit}}</td>
    <td>{{order.totalQuantity}}</td>
  </tr>
</table>
</div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters(['getMedicineToOrderList'])
  }
}
</script>

<style>
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
// component
