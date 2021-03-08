<template>
  <div>
    <navbar />
      <table>
  <tr>
    <th>Medicine Id</th>
    <th>Medicine Name</th>
    <th>Category Id</th>
    <th>Category Name</th>
    <th>Formula</th>
    <th>Dosage</th>
    <th>Cost</th>
    <th>Manufacturer</th>
    <th>MFD Date</th>
    <th>EXP Date</th>
    <th>Quantity</th>
    <th>Total Quantity</th>
    <th>Is In Stock? </th>
  </tr>
  <tr v-for="medicine in getMedicineList" :key="medicine.id">
    <td>{{medicine.medicineId}}</td>
    <td>{{medicine.medicineName}}</td>
    <td>{{medicine.categoryId}}</td>
    <td>{{medicine.categoryName}}</td>
    <td>{{medicine.formula}}</td>
    <td>{{medicine.dosage}}</td>
    <td>{{medicine.costPerUnit}}</td>
    <td>{{medicine.manufacturer}}</td>
    <td>{{medicine.mfdDate.substring(0,10)}}</td>
    <td>{{medicine.expiryDate.substring(0,10)}}</td>
    <td>{{medicine.quantity}} {{medicine.unit}}</td>
    <td>{{medicine.totalQuantity}}</td>
    <td>{{medicine.isInStock}}</td>
  </tr>
</table>
   </div>
</template>
<script>
import { mapGetters } from 'vuex'
import navbar from '@/components/NavBar.vue'
export default {
  data () {
    return {}
  },
  components: {
    navbar
  },
  computed: {
    ...mapGetters(['getMedicineList'])
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
