var app = new Vue({
  el: '#app',
  data: {
    orderItems: [],
  },
  computed: {
    orderTotalPrice: function () {
      return this.orderItems.reduce((total, orderItem) => total += orderItem.price * orderItem.amount, 0);
    }
  },
  methods: {
    showDetail: async function (orderId) {
      this.orderItems = (await axios.get('/api/order/' + orderId +  '/items')).data;
      UIkit.modal("#orderDetailModal").show();
    }
  },
  created: async function () {
  }
})
