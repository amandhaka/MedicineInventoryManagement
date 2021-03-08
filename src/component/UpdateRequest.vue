<template>
  <div class="form-popup" id="UpdateRequestForm">
        <div class="request-container">
        <div>
             <h2>Update Request</h2>
            <div class="flex space-evenly">

                <div>
                    <label for="categoryId"><b>Category Id</b></label>
                    <input type="text" placeholder="Enter category Id" v-model="category_id" required>
                </div>
                <div>
                    <label for="medicineId"><b>Medicine Id</b></label>
                    <input type="text" placeholder="medicineId" v-model="medicine_id" required>
                </div>
            </div>
            <div class="flex space-evenly">
                <div>
                    <label for="quantity"><b>Quantity</b></label>
                    <input type="text" placeholder="quantity" v-model="medicine_quantity" required>
                </div>

                <div>
                    <label for="reason"><b>Reason</b></label>
                    <input type="textarea" placeholder="Reason" v-model="reason" required>
                </div>
                </div>
                <div class="flex space-evenly">
                <div>
                    <label for="requestId"><b>Request Id</b></label>
                    <input type="text" placeholder="requestId" v-model="request_id" required>
                </div>
                </div>
            <button type="submit" class="btn_update_request" @click="onUpdateRequest">Update Request</button>
            <!-- <button type="button" class="btn_cancel" v-on:click="closeForm()">Close</button> -->
        </div>
    </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      request_id: '',
      category_id: '',
      medicine_id: '',
      medicine_quantity: '',
      reason: ''
    }
  },
  methods: {
    onUpdateRequest () {
      this.$store.dispatch('setUpdateRequestObjAction', {
        categoryId: parseInt(this.category_id),
        medicineId: parseInt(this.medicine_id),
        medicineQuantity: parseInt(this.medicine_quantity),
        reason: this.reason,
        requestId: parseInt(this.request_id)
      })
    }
  }

}
</script>

<style scoped>
.request-container{
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
