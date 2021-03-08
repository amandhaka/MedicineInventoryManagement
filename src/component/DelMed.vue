<template>
  <div class="form-popup1" id="del_myform">
      <div class="form-del-container">
      <div>
          <h2> Delete Medicine </h2>
          <div class="flex space-evenly">
          <div>
            <label for="medicineName"><b>Enter Medicine Id</b></label>
            <input type="text" placeholder="Medicine Id" v-model="medicineId" required>
          </div>
          </div>
          <button type="submit" class="btn_delete" @click="ondelete">Delete</button>
      </div>
      </div>
      </div>
</template>
<script>
export default {
  data () {
    return {
    }
  },
  methods: {
    ondelete () {
      console.log(this.medicineId)
      this.$store.dispatch('setDeleteMedicineObjAction', this.medicineId)
    }
  }
}
</script>
<style>
.form-del-container {
    padding: 30px;
    width: 580px;
    border: 3px solid #e45826;
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
.form-popup1 {
  display: flex;
  justify-content: center;
  align-items: center;
  vertical-align: middle;
  margin: auto;
  width: 70%;
}
h2 {
    text-align: center;
}
</style>
// component
