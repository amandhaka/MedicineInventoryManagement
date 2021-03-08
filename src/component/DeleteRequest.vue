<template>
  <div class="form-popup" id="DeleteRequestForm">
        <div class="request-delete-container">
        <div>
             <h2>Delete Request</h2>
            <div class="flex space-evenly">

                <div>
                    <label for="requestId"><b>Enter Request Id</b></label>
                    <input type="text" placeholder="Enter Request Id" v-model="requestId" required>
                </div>
            </div>
            <button type="submit" class="btn_login" @click="onDelete">Delete Request</button>
            <!-- <button type="button" class="btn_cancel" v-on:click="closeForm()">Close</button> -->
        </div>
    </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      requestId: ''
    }
  },
  methods: {
    onDelete () {
      this.$store.dispatch('setDeleteRequestObjAction', {
        requestId: this.requestId
      })
    }
  }
}
</script>

<style>
.request-delete-container{
  display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: 5%;
    margin-right: 5%;
    border: 3px solid #e45826;
    margin-bottom: 10px;
    padding-bottom: 10px ;
    width:60vw;
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
