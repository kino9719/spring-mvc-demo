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
      this.orderItems = (await axios.get('/api/orders/' + orderId +  '/items')).data;
      UIkit.modal("#orderDetailModal").show();
    },
    deleteOrder: async function (orderId) {
      if (confirm('你確定要刪除該訂單嗎？')) {
        (await axios.delete('/api/orders/' + orderId)).data;
        window.location.reload();
      }
    }
  },
  created: async function () {
  }
})
