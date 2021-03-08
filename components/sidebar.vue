<template>
  <div>
    <b-sidebar id="default-sidebar" ref="sidebar" :position="position" :enablePersistence="enablePersistence">
      <div class="title">Content</div>
      <div class="sub-title">Manage Employees</div>
      <div id="head">
        <button
          class="closeButton"
          iconCss="e-icons burg-icon"
          isToggle='true'
          v-on: click
        >Click</button>
      </div>
    </b-sidebar>
  </div>

</template>

<script>
import Vue from 'vue'
import { SidebarPlugin } from '@syncfusion/ej2-vue-navigations'
import { ButtonPlugin } from '@syncfusion/ej2-vue-buttons'
import { enableRipple } from '@syncfusion/ej2-base'
enableRipple(true)

Vue.use(SidebarPlugin)
Vue.use(ButtonPlugin)
export default {
  data () {
    return {
      showBackdrop: false
    }
  },
  methods: {
    toggleClick: function () {
      this.$refs.sidebar.toggle()
    },
    closeClick: function () {
      this.$refs.sidebar.hide()
    },
    close: function () {
      console.log('sidebar closed')
    },
    open: function () {
      console.log('sidebar opened')
    }
  }
}
</script>
<style>

#default-sidebar {
    background-color: rgb(25, 118, 210);
    color: #3caf25;
}

.close-btn:hover {
    color: rgba(0, 0, 0, .87);
    background-color: #b90303;
}
</style>
