module.exports = {
  devServer: {
    overlay: false,
    host: '0.0.0.0',
    hot: true,
    disableHostCheck: true,
  },
  configureWebpack: {},
  transpileDependencies: ['vuetify', 'quasar'],
  pluginOptions: {
    quasar: {
      importStrategy: 'kebab',
      rtlSupport: false,
    },
  },
};
