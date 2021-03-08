<template>
  <div class="form-popup2" id="update_myform">
      <form>
      <div class="form-update-container">
          <h2> Update Medicine </h2>
          <span class="note-class" style="color:#ff0000">ENTER THE ID OF MEDICINE TO UPDATE</span>
          <div class="flex space-evenly">
              <div>
                    <label for="medicineId"><b>Medicine Id</b></label>
                    <input type="text" placeholder="medicineId" v-model="medicineId" required>
                </div>
                <div>
                    <label for="medicineName"><b>Medicine Name</b></label>
                    <input type="text" placeholder="Medicine Name" v-model="medicineName" required>
                </div>
          </div>

          <div class="flex space-evenly">
               <div>
                    <label for="categoryId"><b>Category Id</b></label>
                    <input type="text" placeholder="Enter category Id" v-model="categoryId" required>
                </div>
                <div>
                    <label for="costPerUnit"><b>Cost Per Unit</b></label>
                    <input type="text" placeholder="Enter cost Per Unit" v-model="costPerUnit" required>
                </div>
          </div>

          <div class="flex space-evenly">
               <div>
                    <label for="dosage"><b>Dosage</b></label>
                    <input type="text" placeholder="Enter dosage" v-model="dosage" required>
                </div>
                <div>
                    <label for="expiryDate"><b>Expiry Date</b></label>
                    <input type="date" placeholder="Enter expiryDate" v-model="expiryDate" required>
                </div>
          </div>

          <div class="flex space-evenly">
               <div>
                    <label for="mfdDate"><b>Mfd Date</b></label>
                    <input type="date" placeholder="mfdDate" v-model="mfdDate" required>
                </div>
                <div>
                    <label for="isInStock"><b>Is In Stock</b></label>
                    <input type="checkbox" placeholder="In stock?" v-model="isInStock" required>
                </div>
          </div>

           <div class="flex space-evenly">
                <div>
                    <label for="formula"><b>Formula</b></label>
                    <input type="text" placeholder="Enter Formula" v-model="formula" required>
                </div>

                <div>
                    <label for="manufacturer"><b>Manufacturer</b></label>
                    <input type="text" placeholder="Manufacturer?" v-model="manufacturer" required>
                </div>
            </div>

          <div class="flex space-evenly">
                <div>
                    <label for="quantity"><b>Quantity</b></label>
                    <input type="text" placeholder="quantity" v-model="quantity" required>
                </div>

                <div>
                    <label for="totalQuantity"><b>Total Quantity</b></label>
                    <input type="text" placeholder="Total Quantity" v-model="totalQuantity" required>
                </div>
                </div>
                <div class="flex space-evenly">
                <div>
                    <label for="unit"><b>Unit</b></label>
                    <input type="text" placeholder="Unit" v-model="unit" required>
                </div>
            </div>
          <button type="submit" class="btn_update" @click="onupdate()">Update</button>
      </div>
      </form>
      </div>
</template>

<script>
export default {
  data () {
    return {

    }
  },
  methods: {
    onupdate () {
      console.log('inside on update')
      this.$store.dispatch('setUpdateMedicineObjAction', {
        categoryId: parseInt(this.categoryId),
        medicineId: parseInt(this.medicineId),
        medicineName: this.medicineName,
        costPerUnit: parseInt(this.costPerUnit),
        dosage: this.dosage,
        mfdDate: new Date(this.mfdDate),
        expiryDate: new Date(this.expiryDate),
        formula: this.formula,
        isInStock: this.isInStock,
        manufacturer: this.manufacturer,
        quantity: parseInt(this.quantity),
        totalQuantity: parseInt(this.totalQuantity),
        unit: this.unit
      })
    }
  }
}
</script>

<style scoped>
.note-class{
    font-size: 10px;
}
.form-update-container {
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
h2 {
    text-align: center;
}
</style>
// component
