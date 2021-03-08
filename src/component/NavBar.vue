<template>
  <!-- //<nav class='navbar'> -->
    <ul id="navbar">
      <li><a  style="cursor:pointer" @click="onclick">View Inventory</a></li>
      <li style="left:30%;position:absolute;top:15px;"><input style= "width:300px" class="searchfunctionality" type="text" placeholder="Search" v-model="medicineName" aria-label="Search" /></li>
      <li style="left:52%;position:absolute"><a size="lg" type="submit" outline="white" @click="searchMedicine" style="cursor:pointer" >Search</a></li>
      <li style="right:0;position:absolute"><a @click="onlogout" style="cursor:pointer" >Logout</a></li>
    </ul>
  <!-- </nav> -->
</template>

<script>
export default {
  data () {
    return {
      sliderPosition: 0,
      selectedElementWidth: 0,
      selectedIndex: 0,
      links: [
        {
          id: 1,
          text: 'View Inventory Data'
        },
        {
          id: 2,
          text: 'Logout'
        }
      ]
    }
  },
  methods: {
    onclick () {
      this.$store.dispatch('setMedicineObjAction')
      this.$router.push('/view-inventory')
    },
    onlogout () {
      localStorage.removeItem('JWT_TOKEN')
      this.$router.push('/')
    },
    searchMedicine () {
      if (this.medicineName === undefined) alert('Enter Medicine Name')
      else {
        this.$store.dispatch('setMedicineNameAction', this.medicineName)
        this.$store.dispatch('setMedicineAction')
        setTimeout(() => {
        }, 500)
        this.$router.push('/search-medicine')
      }
    }
  }
}
</script>

<style scoped>
ul#navbar li{
    display: inline;
}
#navbar {
    list-style-type: none;
    margin: 0;
    overflow: hidden;
    background-color: #002244;
    box-shadow: 0 8px 6px -6px #999;
    padding-bottom: 20px;
    padding-top:10px
}
ul#navbar li {
    float:left;
}
ul#navbar li a {
    display: block;
    color: white;
    font-weight:bold;
    padding: 8px 16px;
    text-decoration: none;
    font-family: 'Playfair Display', serif;
}
li a:hover {
    border: 1px solid rgba(255,0,0,0.9);
    color:rgba(255,0,0,0.9);
}
</style>
// component
