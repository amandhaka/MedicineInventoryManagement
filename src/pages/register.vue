<template>
  <div id = "maindiv" @click="clickOnWindow">
    <div class="headcont">
        Medicine Inventory
    </div>
     <div class="cont">
      <div class="cont2">
          <h3>Register</h3>
          <div class="reg-form">
          <input type="text" v-model="name" placeholder="Name" name="name" class="input-css"><br>
          <input type="email" v-model="username" placeholder="Email-id" name="username" class="input-css"><br>
          <input type="password" v-model="password" placeholder="password" name="password" class="input-css"><br>
          <input type="password" v-model="confirmPassword" @keyup="mismatch" placeholder="Confirm Password" name="confirmpassword" class="input-css"><br>
          </div>
          <div class="dropdown">
              <select id = "mySelect" @change="changeUrl" >
                <option>Select User role</option>
                <option value="admin">Admin</option>
                <option value="employee">Employee</option>
              </select>
          </div>
          <button v-on:click="onsubmit()" class="btn">Register</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { mapGetters } from 'vuex'

export default {
  name: 'register',
  data () {
    return {
      path: ''
      // register_username: '',
      // register_password: '',
      // register_name: '',
      // register_cpassword: ''
    }
  },
  computed: {
    ...mapGetters(['getRegUser', 'getRegPassword', 'getRegName'])
  },
  methods: {
    validate () {
      if (!this.name) {
        alert('Please Fill your Name')
        return false
      } else if (!this.username) {
        alert('Please Fill your Email id')
        return false
      } else if (this.password !== this.confirmPassword) {
        alert('password Mismatch')
        return false
      } else {
        return true
      }
    },
    onsubmit () {
      if (this.validate()) {
        const axiosConfig = {
          url: '/register-as-' + this.path,
          baseURL: `http://10.177.68.81:${this.path === 'employee' ? '8082' : '8081'}`,
          method: 'Post',
          data: {
            username: this.username,
            password: this.password,
            name: this.name
          }
        }
        axios(axiosConfig)
          .then(e => console.log(e.data), alert('Registration Success'))
          .catch(e => console.log(e))
      }
      var x = document.getElementById('mySelect')
      if (x.value === 'admin') this.$router.push('/')
      else if (x.value === 'employee') this.$router.push('/')
    },
    changeUrl () {
      var x = document.getElementById('mySelect')
      this.path = x.value
    }
  }
}
</script>

<style scoped>
.headcont{
    height: 50px;
    background-color: #f0a500;
    padding: 10px 10px;
    text-align: center;
    font-size: 30px;
    font-weight: bold ;
    font-family: 'Times New Roman', Times, serif;
}
body{
    margin:0;
    padding:0;
    background-image: url("https://images.unsplash.com/photo-1585435557343-3b092031a831?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDF8fG1lZGljaW5lfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60");
}
.cont{
    display:flex;
    justify-content: center;
}
.cont2{
    width: 35vw;
    height: 50vh;
    border: 2px solid black;
    margin-right: 5%;
    margin-top: 2%;
    text-align: center;
    background-color: #e6d5b8;
    opacity: 0.9;
}
.input-css{
  margin: 5px 5px;
}
.btn{
  margin-top:5px ;
  border: 1px solid yellow;
  border-radius: 20px;
}
#maindiv{
  height: 100vh;
  background-image: url("https://images.unsplash.com/photo-1478744919174-118dbd24973e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1651&q=80");
}
</style>>
