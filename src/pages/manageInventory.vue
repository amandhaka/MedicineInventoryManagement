<template>
  <div>
    <div>
      <navbar />
    </div>
    <div class="btn-inventory">
      <button class="big-button-add" v-on:click="openForm" @click="toggleAddItemBtn">Add an item</button>
      <add-med v-show="visible"/>
      <button class="big-button-update" v-on:click="update_OpenMyForm" @click="toggleUpdateItemBtn">Update Inventory</button>
      <update-med v-show="visible2"/>
      <button class="big-button-del" v-on:click="delete_OpenMyForm" @click="toggleDelItemBtn">Delete an Item</button>
      <del-med v-show="visible1"/>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/NavBar.vue'
import AddMed from '@/components/AddMed.vue'
import UpdateMed from '@/components/UpdateMed.vue'
import DelMed from '@/components/DelMed.vue'
export default {
  components: { Navbar, AddMed, DelMed, UpdateMed },
  data () {
    return {
      visible: false,
      visible1: false,
      visible2: false
    }
  },
  methods: {
    openForm () {
      document.getElementById('myForm').style.display = 'block'
    },
    closeForm () {
      document.getElementById('myForm').style.display = 'none'
    },
    toggleAddItemBtn () {
      if (this.visible === true) this.visible = false
      else this.visible = true
    },
    delete_OpenMyForm () {
      document.getElementById('del_myform').style.display = 'block'
    },
    delete_closeMyForm () {
      document.getElementById('del_myform').style.display = 'none'
    },
    toggleDelItemBtn () {
      if (this.visible1 === true) this.visible1 = false
      else this.visible1 = true
    },
    update_OpenMyForm () {
      document.getElementById('update_myform').style.display = 'block'
    },
    update_closeMyForm () {
      document.getElementById('update_myform').style.display = 'none'
    },
    toggleUpdateItemBtn () {
      if (this.visible2 === true) this.visible2 = false
      else this.visible2 = true
    }
  },
  created  () {
    const jwt = localStorage.getItem('JWT_TOKEN')
    if (jwt === null) {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.big-button-add {
  padding: 15px 25px;
  font-size: 24px;
  width: 100%;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color:#89CFF0;
  border: none;
  border-radius: 15px;
 -webkit-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
-moz-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
  display: block;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.big-button-del {
  padding: 15px 25px;
  font-size: 24px;
  width: 100%;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  border: none;
  border-radius: 15px;
  background-color:#89CFF0;
  -webkit-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
-moz-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
  display: block;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.big-button-update {
  padding: 15px 25px;
  font-size: 24px;
  width: 100%;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color:#89CFF0;
  border: none;
  border-radius: 15px;
-webkit-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
-moz-box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
box-shadow: 13px 14px 12px -4px rgba(208,227,232,1);
  display: block;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
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
.btn-inventory{
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: 5%;
    margin-right: 5%;
}
</style>>
