<template>
  <div>
    <div class="hide" id="hidden">
        <div id="popup">
          <div class="form-header">
              <h3 style="font-family: 'Josefin Slab', serif;">Login Here..</h3>
          </div>
          <div class="form-content">
              <div>
                <input type="text" placeholder="Username" v-model="username">
                <input type="password" placeholder="Password" v-model="password">
                <input type="password" placeholder="Confirm Password" v-model="cpassword">
              </div>
                <div class="dropdown">
                  <select id = "mySelect" @change="changeUrl" >
                   <option>Select User role</option>
                   <option value="admin">Admin</option>
                   <option value="employee">Employee</option>
                  </select>
                </div>
              <button class="btn4" v-on:click="onsubmit()">Login</button>
          </div>
        </div>
    </div>
    <div id="main-content">
      <header>
        <div id="img1"></div>
        <div id="img2"></div>
        <div id="img3"></div>
        <div id="img4"></div>
        <div id="img5"></div>
      <div class="cont-main">
        <nav>
        <ul type="none" class="nav-ul">
          <li class="nav-li">
          <button class="bttn" v-on:click="clickme()">Login</button>
        </li>
        <li id="li-head" class="nav-li" style ="font-weight:bold;">
            Medicine Inventory
        </li>
        <li class="nav-li">
            <router-link to ="/register"><button class="bttn1">Register</button></router-link>
        </li>
        </ul>
      </nav>
      </div>
    </header>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  data () {
    return {
      username: '',
      password: '',
      cpassword: '',
      Adm: '',
      path: ''
    }
  },
  computed: {
    ...mapGetters(['getUsername', 'getPassword'])
  },
  methods: {
    clickme () {
      document.getElementById('popup').style.display = 'block'
      document.getElementById('hidden').style.display = 'block'
      document.getElementById('main-content').style.opacity = '0.6'
    },
    changeUrl () {
      var x = document.getElementById('mySelect')
      this.path = x.value
    },
    validate () {
      if (!this.username) {
        alert('Please enter username')
      }
      if (!this.password) {
        alert('Please enter password')
      }
      if (!this.cpassword) {
        alert('Please enter confirm password')
      }
      if (this.password !== this.cpassword) {
        alert('Different password')
        return false
      } else if (this.password === this.cpassword) {
        console.log('same')
        return true
      }
    },
    onsubmit () {
      this.$store.dispatch('setPathAction', this.path)
      if (this.validate()) {
        this.$store.dispatch('login', {
          username: this.username,
          password: this.password
        })
      }
      console.log(this.$store.getUsername)
      console.log(this.$store.getPassword)
    }
  },
  created () {
    window.addEventListener('click', (event) => {
      var modal = document.getElementById('hidden')
      if (event.target === modal) {
        modal.style.display = 'none'
        document.getElementById('main-content').style.opacity = '1'
      }
    })
  }
}
</script>

<style scoped>
body{
    margin:0px auto;
    padding:0px auto;
    overflow-x: hidden;
}
#main-content{
  opacity: 1;
}
.cont-main{
  background-color: transparent;
    width: 100vw;
    position: absolute;
    top: 0px;
}
.nav-ul{
  display: flex;
  justify-content: center;
  margin-top: 5px;
}

.form-ul{
  display: flex;
  justify-content: center;
  flex-direction: column;
}
#li-head{
  font-size: 30px;
  font-family: 'Times New Roman', Times, serif;
  margin-left:10px ;
  margin-right:10px ;
}
.form-content{
  margin: 5px 5px;
}
header{
    height:100vh;
    width:100vw;
    text-align:center;
}
.hide{
    width:100vw;
    height:100vh;
    position: fixed;
    top:0px;
    left:0px;
    z-index:2;
    display:none;
}
nav{
  background-color: transparent;
    width: 100vw;
    position: absolute;
    top: 0px;
}
.nav-li{
  font-family: 'Anton', sans-serif;
}
.bttn{
    font-size:30px;
    padding:10px 20px 10px 20px;
    text-decoration: none;
    color: #4a47a3;
    border: none;
    padding:0;
    background:none;
    margin-left: 15px;
    margin-right: 15px;
    position: absolute;
    left:0;
}

.bttn:hover {
  font-size:40px;
  transition: 1.2s;
}
.bttn1:hover {
  font-size:40px;
  transition: 1.2s;
}
.bttn1 {
  position: absolute;
  right:0;
    font-size:30px;
    padding:10px 20px 10px 20px;
    text-decoration: none;
    color: #4a47a3;
    border: none;
    padding:0;
    background:none;
    margin-left: 15px;
    margin-right: 15px;
}
#popup{
    display:none;
    padding:80px;
    position:absolute;
    background:#f1f1f1;
    border-radius:5px;
    text-align: center;
    z-index:3;
    width:350px;
    height: 400px;
    top:50%;
    left:50%;
    transform:translate(-50%,-50%) ;
    box-shadow: 0px 0px 50px 1px #000;
}
input[type=text] {
  padding: 8px 8px;
  margin: 8px 0;
  box-sizing: border-box;
}
input[type=password] {
  padding: 8px 8px;
  margin: 8px 0;
  box-sizing: border-box;
}
.form-ul{
  display: block;
}
.form-li{
  list-style-type: none;
  margin: 5px 5px;
}
#mySelect {
  padding:10px 0;
  margin-bottom: 5px;
}
#box{
    right: 0;
    position: absolute;
    top:60%;
    left:21%;
    transform:translate(-40%,-40%);
}
#img1{
    position:absolute;
    top:0;
    height:100vh;
    width:100vw;
    background: url("../assets/jar.jpg");
    text-align: center;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    overflow-y:hidden;
    animation-name:background_change1;
    animation-iteration-count: infinite;
    animation-duration: 10s;
}
#img2{
    position: absolute;
    top:0;
    height:100vh;
    width:100vw;
    background: url("../assets/mask.png");
    text-align: center;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    overflow-y:hidden;
    animation-name:background_change2;
    animation-iteration-count: infinite;
    animation-duration:10s;
}
#img3{
    position: absolute;
    top:0;
    height:100vh;
    width:100vw;
    background: url("../assets/pill.jpg");
    text-align: center;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    overflow-y:hidden;
    animation-name:background_change3;
    animation-iteration-count: infinite;
    animation-duration:10s;
}
#img4{
    position: absolute;
    top:0;
    height:100vh;
    width:100vw;
    background: url("../assets/syringe.jpg");
    text-align: center;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    overflow-y:hidden;
    animation-name:background_change4;
    animation-iteration-count: infinite;
    animation-duration:10s;
}
@keyframes background_change1{
    0%{
        opacity: 0;
    }
    25%{
        opacity: 1;
    }
    50%{
        opacity: 0;
    }
    75%{
        opacity: 0;
    }
    100%{
        opacity: 0;
    }
}
@keyframes background_change2{
    0%{
        opacity: 0;
    }
    25%{
        opacity: 0;
    }
    50%{
        opacity: 1;
    }
    75%{
        opacity: 0;
    }
    100%{
        opacity: 0;
    }

}
@keyframes background_change3{
    0%{
        opacity: 0;
    }

    25%{
        opacity: 0;
    }
    50%{
        opacity: 0;
    }
    75%{
        opacity: 1;
    }
    100%{
        opacity:0;
    }
}
@keyframes background_change4{

    0%{
        opacity:1;
    }
    25%{
        opacity: 0;
    }
    50%{
        opacity: 0;
    }
    75%{
        opacity: 0;
    }
    100%{
        opacity:1;
    }
}

</style>>
