module.exports = {
  devServer: {
    overlay: false,
  },

  transpileDependencies: ['vuetify', 'quasar'],

  pluginOptions: {
    quasar: {
      importStrategy: 'kebab',
      rtlSupport: false,
    },
  },
};
