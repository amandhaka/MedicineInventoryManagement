<template>
  <div>
    <div>
      <navbar />
    </div>
    <div class="btn-request">
      <button class="big-button" v-on:click="ViewRequestForm()" @click="toggleViewRequestBtn()">View Request</button>
      <view-request v-show="visible1"/>
      <button class="big-button" v-on:click="UpdateRequestForm()" @click="toggleUpdateRequestBtn()">Update Request</button>
      <update-request v-show="visible2"/>
      <button class="big-button" v-on:click="delRequestForm()" @click="toggleDelRequestBtn()">Delete Request</button>
      <delete-request v-show="visible3" class="center"/>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/NavBar.vue'
import DeleteRequest from '@/components/DeleteRequest.vue'
import UpdateRequest from '@/components/UpdateRequest.vue'
import viewRequest from '@/components/ViewRequest.vue'
export default {
  components: { Navbar, DeleteRequest, UpdateRequest, viewRequest },
  data () {
    return {
      visible1: false,
      visible2: false,
      visible3: false
    }
  },
  methods: {
    created () {
      const jwt = localStorage.getItem('JWT_TOKEN')
      if (jwt === null) {
        this.$router.push('/')
      }
    },
    ViewRequestForm () {
      document.getElementById('viewRequest').style.display = 'block'
      this.$store.dispatch('setViewRequestObjAction')
    },
    closeFormReqView () {
      document.getElementById('viewRequest').style.display = 'none'
    },
    toggleViewRequestBtn () {
    //  this.$store.dispatch('setViewRequestObjAction')
      if (this.visible1 === true) this.visible1 = false
      else this.visible1 = true
    },
    // =======
    UpdateRequestForm () {
      document.getElementById('UpdateRequestForm').style.display = 'block'
    },
    closeFormReqUpdate () {
      document.getElementById('UpdateRequestForm').style.display = 'none'
    },
    toggleUpdateRequestBtn () {
      if (this.visible2 === true) this.visible2 = false
      else this.visible2 = true
    },
    delRequestForm () {
      document.getElementById('DeleteRequestForm').style.display = 'block'
    },
    closeFormReq () {
      document.getElementById('DeleteRequestForm').style.display = 'none'
    },
    toggleDelRequestBtn () {
      if (this.visible3 === true) this.visible3 = false
      else this.visible3 = true
    }
  }
}
</script>

<style scoped>
.center{
  margin: auto;
}
.big-button {
  padding: 15px 25px;
  font-size: 24px;
  width: 100%;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: rgb(13, 188, 194);
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
.btn-request{
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: 5%;
    margin-right: 5%;
}
</style>
