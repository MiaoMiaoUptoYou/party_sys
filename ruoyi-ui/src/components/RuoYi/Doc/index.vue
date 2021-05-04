<template>
  <div>
    <svg-icon icon-class="question" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'RuoYiDoc',
  data() {
    return {
      url: 'https://github.com/MiaoMiaoUptoYou/party_sys'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
