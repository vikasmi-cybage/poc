<template>
  <div class="login" style="margin-left: 493px;margin-top: 21px;">
    <h1>{{ msg }}</h1>
    <div class="row col-sm-12">
      <div class= "row col-sm-12">
        <span>UserName :</span>
        <input type="text" name="username" v-model="login.username">
      </div>
      <div class="row col-sm-12">
        <span>password :</span>
        <input type="password" v-model="login.password" name="password">
      </div>
      <div class="row col-sm-12">
        <button type="button" v-on:click.prevent="loginForm" class="btn btn-success"> submit</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {

  name: 'login',
  data () {
    return {
      msg: 'Please Login To Access Application',
      login: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    loginForm () {
      console.log('Login POJO :: ' + JSON.stringify(this.login))
      if (this.login.username === 'root' && this.login.password === 'root') {
        this.$router.push({ path: 'studentList' })
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1,
  h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
