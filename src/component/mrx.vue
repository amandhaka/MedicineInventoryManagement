<template>
<div>
  <div id="mySidenav" class="sidenav">
  <!-- <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> -->
  <div class="list">
    <!-- <a href="#">Manage Inventory</a>
    <a href="#">Manage Employees</a>
    <a href="#">Manage Order</a> -->
    <div class="class-inventory">
      <router-link to="/manage-inventory/">Manage Inventory</router-link>
      <img src="https://cdn4.iconfinder.com/data/icons/hospital-medical-2/162/medical-hospital-medicine_77-512.png" class="inventory-icon">
    </div>
    <div class="class-request">
      <router-link to="/manage-request/">Manage Request</router-link>
      <img src="https://www.pngitem.com/pimgs/m/452-4527514_zoho-inventory-logo-hd-png-download.png" class="order-icon">
    </div>
    <div class="class-order">
      <router-link to="/manage-order/">Manage Order</router-link>
      <img src="https://www.pngitem.com/pimgs/m/452-4527514_zoho-inventory-logo-hd-png-download.png" class="order-icon">
    </div>
    <div class="class-viewEmployee">
        <button id="employeeButton" class="empButton" @click="showEmployeeList">View Employees List</button>
      <img src="https://cdn0.iconfinder.com/data/icons/hexagon-business-flat-part-2/218/Search-512.png" class="view-employee-icon">
    </div>
  </div>
</div>
</div>
</template>

<script>

export default {
  name: 'SideBar2',
  data () {
    return {

    }
  },
  methods: {
    openNav () {
      document.getElementById('mySidenav').style.width = '250px'
    },
    closeNav () {
      document.getElementById('mySidenav').style.width = '0'
    },
    showEmployeeList () {
      this.$store.dispatch('setEmployeeListAction')
      this.$router.push('/manage-employee')
    }
  }
}
</script>
<style scoped>

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
  margin-top: 10%;
}
.sidenav a:hover {
  color: #1dc6cc;
}
.empButton:hover{
  color: #1dc6cc;
}
#main {
  transition: margin-left .5s;
  padding: 20px;
}
.list{
  display: flex;
  margin-left: 10% ;
  margin-right: 10%;
  flex-direction: row;
  justify-content: space-around;
  align-items: baseline;
  font-family: 'Crimson Text', serif;
}
.inventory-icon{
  height: 30px;
  width: 30px;
  animation: updown 2s ease infinite;
}
@keyframes updown {
  0% {
    transform: translateX(-100%);
  }
  50% {
    transform: translateX(100%);
  }
  100% {
    transform: translateX(-100%);
  }
}
.employee-icon{
  height: 30px;
  width: 30px;
  animation: updown 2s ease infinite;
}
.order-icon{
  height: 30px;
  width: 30px;
  animation: updown 2s ease infinite;
}
.view-employee-icon{
  position: relative;
  height: 30px;
  width: 30px;
  animation: updown 2s ease infinite;
  top:35px;
  right: 230px;
}
button {
  border: none;
  padding:0;
  background:none;
  font-family: 'Crimson Text', serif;
  font-size: 25px;
  color: #818181;
}
</style>>
// component
