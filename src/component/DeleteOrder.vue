<template>
  <div id="DeleteOrderDiv">
        <div>
        <div>
             <h2>Delete Order</h2>
            <div class="flex space-evenly">

                <div>
                    <label for="orderId"><b>Enter Order Id</b></label>
                    <input type="text" placeholder="Enter Order Id" v-model="orderId" required>
                </div>
            </div>
            <button type="submit" class="btn_login" @click="onDeleteOrder">Delete Order</button>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      orderId: ''
    }
  },
  methods: {
    onDeleteOrder () {
      this.$store.dispatch('setDeleteOrderObjAction', {
        orderId: this.orderId
      })
    }
  }
}
</script>

<style scoped>
#DeleteOrderDiv{
  border: 3px solid #e45826;
  width: 30vw;
  height: 22vh;
  padding:10px 10px;
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
</style>
// component
