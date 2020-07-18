var app = new Vue({
  el: '#app',
  data: {
    username: '',
    password: '',
  },
  computed: {
  },
  methods: {
    login: async function () {
      try {
        await axios.post('/api/login', {
          username: this.username,
          password: this.password,
        });
        window.location.href = "/";
      } catch (error) {
        UIkit.notification({
            message: '帳號或密碼錯誤',
            status: 'danger',
            pos: 'top-center',
            timeout: 3000
        });
      }
    }
  },
  created: async function () {
  }
})
