<template>
  <div class="search">
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
  <tr>
    <td>{{getMedicineObject.medicineId}}</td>
    <td>{{getMedicineObject.medicineName}}</td>
    <td>{{getMedicineObject.categoryId}}</td>
    <td>{{getMedicineObject.categoryName}}</td>
    <td>{{getMedicineObject.formula}}</td>
    <td>{{getMedicineObject.dosage}}</td>
    <td>{{getMedicineObject.costPerUnit}}</td>
    <td>{{getMedicineObject.manufacturer}}</td>
    <td>{{getMedicineObject.mfdDate.substring(0,10)}}</td>
    <td>{{getMedicineObject.expiryDate.substring(0,10)}}</td>
    <td>{{getMedicineObject.quantity}} {{getMedicineObject.unit}}</td>
    <td>{{getMedicineObject.totalQuantity}}</td>
    <td>{{getMedicineObject.isInStock}}</td>
  </tr>
</table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Navbar from '@/components/NavBar.vue'
export default {
  components: { Navbar },
  name: 'searchMedicine',
  computed: {
    ...mapGetters(['getMedicineObject'])
  }
}
</script>

<style>
</style>
