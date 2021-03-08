<template>
<div>
  <navbar />
  <!-- <nav class='navbar'>
      <button @click="onclick">view Inventory Data</button>
      <form class="search-func">
        <input class="searchfunctionality" type="text" placeholder="Search" aria-label="Search" />
        <button size="lg" type="submit" outline="white">Search</button>
      </form>
      <router-link to="/">Logout</router-link>
  </nav> -->
  <table>
  <tr>
    <th>Employee Id</th>
    <th>Employee Username</th>
    <th>Employee Name</th>
  </tr>
  <tr v-for="employee in getEmployeeList" :key="employee.id">
    <td>{{employee.id}}</td>
    <td>{{employee.username}}</td>
    <td>{{employee.name}}</td>
  </tr>
</table>

</div>
</template>

<script>
import { mapGetters } from 'vuex'
import navbar from '@/components/NavBar.vue'
export default {
  computed: {
    ...mapGetters(['getEmployeeList'])
  },
  components: {
    navbar
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
/* The popup form - hidden by default */
.form-popup {
  border: 3px solid #f1f1f1;
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
