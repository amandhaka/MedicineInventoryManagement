import Vue from 'vue'
import VueRouter from 'vue-router'
import admin from '@/pages/admin.vue'
import employee from '@/pages/employee.vue'
import manageRequest from '@/pages/manageRequest.vue'
import manageInventory from '@/pages/manageInventory.vue'
import manageEmployee from '@/pages/manageEmployee.vue'
import viewInventory from '@/pages/viewInventory.vue'
import register from '@/pages/register.vue'
import homePage from '@/pages/homePage.vue'
import manageOrder from '@/pages/manageOrder.vue'
import error from '@/pages/error.vue'
import searchMedicine from '@/pages/searchMedicine.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/register',
    name: 'register',
    component: register
  },
  {
    path: '/search-medicine',
    name: 'searchMedicine',
    component: searchMedicine
  },
  {
    path: '/error',
    name: 'error',
    component: error
  },
  {
    path: '',
    mane: '/login-as',
    component: homePage
  },
  {
    path: '/admin',
    name: 'admin',
    component: admin
  },
  {
    path: '/employee',
    name: 'employee',
    component: employee
  },
  {
    path: '/manage-request',
    name: 'manageRequest',
    component: manageRequest
  },
  {
    path: '/manage-inventory',
    name: 'manageInventory',
    component: manageInventory
  },
  {
    path: '/manage-employee',
    name: 'manageEmployee',
    component: manageEmployee
  },
  {
    path: '/view-inventory',
    name: 'viewInventory',
    component: viewInventory
  },
  {
    path: '/manage-order',
    name: 'manageOrder',
    component: manageOrder
  },
  {
    path: '*',
    name: ''
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
export default router
