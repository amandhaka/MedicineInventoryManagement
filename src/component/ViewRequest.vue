<template>
  <div>
    <div id="viewRequest">
      <h1>All Request</h1>
    </div>
    <table>
  <tr>
    <th>Medicine Id</th>
    <th>Category Id</th>
    <th>Request Id </th>
    <th>Medicine Quantity</th>
    <th>Reason</th>
  </tr>
  <tr v-for="request in getViewRequestList" :key="request.id">
    <td>{{request.medicineId}}</td>
    <td>{{request.categoryId}}</td>
    <td>{{request.requestId}}</td>
    <td>{{request.medicineQuantity}}</td>
    <td>{{request.reason}}</td>
  </tr>
</table>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  data () {
    return {}
  },
  computed: {
    ...mapGetters(['getViewRequestList'])
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
</style>>
// component
