// utkarsh
import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    jwtToken: '',
    username: '',
    password: '',
    cpassword: '',
    register_username: '',
    register_password: '',
    register_name: '',
    register_cpassword: '',
    path: '',
    medicineList: [], // for view medicine inventory
    newRequestList: [], // for new request of medicine
    deleteRequestList: '', // for delete request of medicine
    updateRequestList: [],
    newMedicineList: [], // for create medicine
    delMedicineList: '', // for delete medicine
    updateMedicineList: [], // for updating medicine
    requestId: '',
    requestList: [],
    employeeList: [],
    deleteOrderList: '',
    newOrderList: [],
    medicineObject: {},
    medicineName: '',
    orderList: [],
    medicineToOrderList: []
  },
  getters: {
    getMedicineToOrderList (state) {
      return state.medicineToOrderList
    },
    getOrderList (state) {
      return state.orderList
    },
    getEmployeeList (state) {
      return state.employeeList
    },
    getPath (state) {
      return state.path
    },
    getJwtToken (state) {
      return state.jwtToken
    },
    getUsername (state) {
      return state.username
    },
    getPassword (state) {
      return state.password
    },
    getCPassword (state) {
      return state.cpassword
    },
    getRegUser (state) {
      return state.register_username
    },
    getRegPassword (state) {
      return state.register_password
    },
    getRegName (state) {
      return state.register_name
    },
    getRegCPassword (state) {
      return state.register_cpassword
    },
    getMedicineList (state) {
      return state.medicineList
    },
    getNewRequestList (state) { // getter for New Request
      return state.newRequestList
    },
    getUpdateRequestList (state) { // getter for update request
      return state.updateRequestList
    },
    getDeleteRequestList (state) { // delete request
      return state.deleteRequestList
    },
    getViewRequestList (state) { // view request List
      return state.requestList
    },
    getDeleteOrderList (state) {
      return state.deleteOrderList
    },
    getNewOrderList (state) {
      return state.newOrderList
    },
    getMedicine (state) {
      return state.medicineName
    },
    getMedicineObject (state) {
      return state.medicineObject
    },
    getNewMedicineList (state) { // for create medicine
      return state.newMedicineList
    },
    getdeleteMedicine (state) { // for delete a medicine delMedicineList
      return state.delMedicineList
    },
    getupdateMedicine (state) { // for updating a medicine
      return state.updateMedicineList
    }
  },
  mutations: {
    setMedicineToOrderList (state, value) {
      state.medicineToOrderList = value
    },
    setOrderList (state, value) {
      state.orderList = value
    },
    setEmployeeList (state, value) {
      state.employeeList = value
    },
    setPath (state, value) {
      state.path = value
    },
    setToken (state, value) {
      state.jwtToken = value
    },
    setUsername (state, value) {
      state.username = value
    },
    setPassword (state, value) {
      state.password = value
    },
    setCPassword (state, value) {
      state.cpassword = value
    },
    setRegUser (state, value) {
      state.register_username = value
    },
    setRegPassword (state, value) {
      state.register_password = value
    },
    setRegName (state, value) {
      state.register_name = value
    },
    setRegCPassword (state, value) {
      state.register_cpassword = value
    },
    setMedicineList (state, value) {
      state.medicineList = value
    },
    setNewRequestList (state, value) { // setter for New Request list
      state.newRequestList = value
    },
    setUpdateRequestList (state, value) { // setter for update Request list
      state.updateRequestList = value
    },
    setDeleteRequestList (state, value) { // for delete request
      state.deleteRequestList = value
    },
    setViewRequestList (state, value) { // for Request list
      state.requestList = value
    },
    setDeleteOrderList (state, value) {
      state.deleteOrderList = value
    },
    setNewOrderList (state, value) { // setter for new order list
      state.newOrderList = value
    },
    setNewMedicineList (state, value) { // for create medicine
      state.newMedicineList = value
    },
    setDeleteMedicineList (state, value) { // for delete a medicine
      state.delMedicineList = value
    },
    setUpdateMedicineList (state, value) { // for updating a medicine
      state.updateMedicineList = value
    },
    setMedicineName (state, value) {
      state.medicineName = value
    },
    setMedicineObject (state, value) {
      state.medicineObject = value
    }
  },
  actions: {
    setJwtTokenAction ({ commit, state }, obj) {
      commit('setJwtToken', obj.jwtToken)
      const axiosConfig = {
        url: '/login-as-' + state.path,
        method: 'Post',
        baseURL: `http://10.177.68.81:${state.path === 'employee' ? '8082' : '8081'}/`,
        data: {
          username: this.state.username,
          password: this.state.password
        }
      }
      axios(axiosConfig)
        .then((e) => {
          console.log(e)
        })
        .catch((e) => console.log(e))
    },
    login ({ commit, state }, obj) {
      const axiosConfig = {
        url: '/login-as-' + state.path,
        method: 'Post',
        baseURL: `http://10.177.68.81:${state.path === 'employee' ? '8082' : '8081'}/`,
        data: {
          username: obj.username,
          password: obj.password
        }
      }
      axios(axiosConfig)
        .then((e) => {
          console.log(e)
          const jwt = e.data.jwt
          commit('setJwtToken', obj.jwtToken)
          localStorage.setItem('JWT_TOKEN', jwt)
          router.push(`/${state.path}`)
        })
        .catch((e) => router.push('/error'))
    },
    setPathAction ({ commit }, value) {
      commit('setPath', value)
    },
    setMedicineObjAction ({ commit }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/medicine/viewMedicineList',
        method: 'get'
      }
      axios(axiosConfig)
        .then(e => {
          console.log(e.data)
          commit('setMedicineList', e.data)
        })
        .catch(e => alert('NO DATA AVAILABLE'))
    },
    setNewMedicineObjAction  ({ commit, state }, obj) { // for create medicine
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/medicine/createMedicine',
        method: 'Post',
        data: {
          categoryId: obj.categoryId,
          costPerUnit: obj.costPerUnit,
          dosage: obj.dosage,
          expiryDate: obj.expiryDate,
          formula: obj.formula,
          isInStock: obj.isInStock,
          manufacturer: obj.manufacturer,
          medicineId: obj.medicineId,
          medicineName: obj.medicineName,
          mfdDate: obj.mfdDate,
          quantity: obj.quantity,
          totalQuantity: obj.totalQuantity,
          unit: obj.unit
        }
      }
      axios(axiosConfig)
        .then(e => alert('Created'), alert('Medicine added successfully'))
        .catch(e => console.log('Medicine not created'))
    },
    setDeleteMedicineObjAction ({ commit, state }, medicineId) { // for delete a medicine
      console.log(medicineId)
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/medicine/deleteMedicine/${medicineId}`,
        method: 'DELETE',
        data: {
          medicineId: medicineId
        }
      }
      console.log('inside del med2')
      axios(axiosConfig)
        .then(e => alert('Medicine Deleted'))
        .catch(e => console.log('Medicine cannot be deleted'))
    },
    setUpdateMedicineObjAction ({ commit, state }, obj) { // for updating medicine
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/medicine/updateMedicine/${obj.medicineId}`,
        method: 'PUT',
        data: {
          medicineId: obj.medicineId,
          medicineName: obj.medicineName,
          categoryId: obj.categoryId,
          manufacturer: obj.manufacturer,
          formula: obj.formula,
          mfdDate: obj.mfdDate,
          expiryDate: obj.expiryDate,
          dosage: obj.dosage,
          quantity: obj.quantity,
          unit: obj.unit,
          totalQuantity: obj.totalQuantity,
          costPerUnit: obj.costPerUnit,
          isInStock: obj.isInStock
        }
      }
      axios(axiosConfig)
        .then(e => alert('Medicine Updated'))
        .catch(e => alert('Medicine not updated'))
    },
    setUpdateMedicineListAction ({ commit }, value) {
      commit('setUpdateMedicineList', value)
    },
    setNewRequestObjAction ({ commit, state }, obj) {
      console.log('Inside Request')
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/request/createRequest',
        method: 'Post',
        data: {
          categoryId: obj.categoryId,
          medicineId: obj.medicineId,
          medicineQuantity: obj.medicineQuantity,
          reason: obj.reason
        }
      }
      axios(axiosConfig)
        .then(e => console.log(e), alert('Medicine request sent successfully'))
        .catch(e => console.log('Medicine request not sent'))
    },
    setNewRequestListAction ({ commit }, value) {
      commit('setNewRequestList', value)
    },
    setMedicineAction ({ commit, state }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/medicine/viewMedicine?medicineName=${state.medicineName}`,
        method: 'GET'
      }
      axios(axiosConfig)
        .then(e => {
          commit('setMedicineObject', e.data)
        })
        .catch(e => alert('No Medicine Available'))
    },
    setDeleteRequestObjAction ({ commit, state }, obj) { // for delete request
      console.log('Inside delete Request')
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/request/deleteRequest/${obj.requestId}`,
        method: 'DELETE',
        data: {
          requestId: obj.requestId
        }
      }
      axios(axiosConfig)
        .then(e => console.log(e), alert('Medicine deleted'))
        .catch(e => console.log('Medicine not deleted'))
    },
    setDeleteRequestListAction ({ commit }, value) {
      commit('setDeleteRequestList', value)
    },
    setUpdateRequestObjAction ({ commit, state }, obj) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/request/updateRequest/${obj.requestId}`,
        method: 'PUT',
        data: {
          requestId: obj.requestId,
          categoryId: obj.categoryId,
          medicineId: obj.medicineId,
          medicineQuantity: obj.medicineQuantity,
          reason: obj.reason
        }
      }
      axios(axiosConfig)
        .then(e => console.log(e), alert('Request updated'))
        .catch(e => console.log('Request not updated'))
    },
    setUpdateRequestListAction ({ commit }, value) {
      commit('setUpdateRequestList', value)
    },
    setViewRequestObjAction ({ commit }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/request/viewRequestList',
        method: 'get'
      }
      axios(axiosConfig)
        .then(e => {
          commit('setViewRequestList', e.data)
        })
        .catch(e => alert('NO REQUEST DATA AVAILABLE'))
    },
    setEmployeeListAction ({ commit, state }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.81:8082/',
        url: '/get-employee-list',
        method: 'get'
      }
      axios(axiosConfig)
        .then(e => {
          commit('setEmployeeList', e.data)
        })
        .catch(e => alert('NO EMPLOYEES'))
    },
    setDeleteOrderObjAction ({ commit, state }, obj) { // for delete order
      console.log('Inside delete Order')
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: `/order/deleteOrderById/${obj.orderId}`,
        method: 'DELETE',
        data: {
          requestId: obj.orderId
        }
      }
      axios(axiosConfig)
        .then(e => console.log(e), alert('Order deleted successfully'))
        .catch(e => console.log('Order not deleted'))
    },
    setDeleteOrderListAction ({ commit }, value) {
      commit('setDeleteOrderList', value)
    },
    setNewOrderObjAction ({ commit, state }, obj) {
      console.log('Inside create Object')
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/order/createOrder',
        method: 'Post',
        data: {
          medicineId: obj.medicineId,
          medicineQuantity: obj.medicineQuantity,
          orderId: obj.orderId,
          orderDate: obj.orderDate,
          totalAmount: obj.totalAmount
        }
      }
      axios(axiosConfig)
        .then(e => console.log(e), alert('Order Request Sent successfully'))
        .catch(e => console.log('Order create new request Not Sent'))
    },
    setNewOrderListAction ({ commit }, value) {
      commit('setNewOrderList', value)
    },
    setMedicineNameAction ({ commit, state }, value) {
      commit('setMedicineName', value)
    },
    setMedicineOrderAction ({ commit, state }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/order/viewOrderList',
        method: 'get'
      }
      axios(axiosConfig)
        .then(e => commit('setOrderList', e.data))
        .catch(e => alert('Currently No Orders'))
    },
    setMedicineToOrderAction ({ commit, state }, value) {
      const axiosConfig = {
        baseURL: 'http://10.177.68.71:8083/',
        url: '/medicine/viewMedicineToOrder',
        method: 'get'
      }
      axios(axiosConfig)
        .then(e => commit('setMedicineToOrderList', e.data))
        .catch(e => alert('No medicine to Order'))
    }
  }
})
