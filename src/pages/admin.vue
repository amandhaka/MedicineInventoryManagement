<template>
    <div>
        <navbar/>
        <span class="menu-class" style="font-size:30px;cursor:pointer" @click="toggleSideBar">Menu</span>
        <sidebar v-show="ok"/>
        <div class="container">
          <div class="font-container" style = "font-family: 'Dancing Script', cursive; font-size:30px"><p>"Laughter is the best medicine - unless you're diabetic, then insulin comes pretty high on the list"</p></div>
          <img src="../assets/adminteam.jpeg">
        </div>
    </div>
</template>

<script>
import navbar from '@/components/NavBar.vue'
import side from '@/components/mrx.vue'
export default {
  name: 'admin',
  components: {
    navbar: navbar,
    sidebar: side
  },
  data () {
    return {
      ok: false
    }
  },
  methods: {
    toggleSideBar () {
      if (this.ok === true) this.ok = false
      else this.ok = true
    }
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
.menu-class{
  margin-left:10px;
}
p {
  animation-duration: 3s;
  animation-name: slidein;
  font-size: 100%;
  text-align: center;
}
.font-container{
  transition: 1s;
}
img {
  width: 500px  !important;
  height: 300px  !important;
  left:50%;
  top:50%;
  transform:translate(50%,10%);
  animation: slidein 1s ease-in;
}
@keyframes slidein {
  from {
    margin-left: 100%;
    width: 300%;
  }
  75% {
    font-size: 150%;
    margin-left: 25%;
    width: 150%;
  }
  to {
    margin-left: 0%;
    width: 100%;
  }
}
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
.container{
  height: 50vh;
  width: 100vw;
  background-color: transparent;
  overflow-x: hidden;
  overflow-y:hidden;
  -webkit-box-shadow: 13px 10px 13px 6px rgba(188,223,232,1);
  -moz-box-shadow: 13px 10px 13px 6px rgba(188,223,232,1);
  box-shadow: 13px 10px 13px 6px rgba(188,223,232,1);
}
</style>
