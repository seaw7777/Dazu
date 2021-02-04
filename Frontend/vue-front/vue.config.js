module.exports = {
  devServer: {
    overlay: false,
  },
  configureWebpack: {
	// other webpack options to merge in ...
	},
  devServer: {
  host: "0.0.0.0",
  hot: true,
  disableHostCheck: true
  },

  transpileDependencies: ['vuetify', 'quasar'],

  pluginOptions: {
    quasar: {
      importStrategy: 'kebab',
      rtlSupport: false,
    },
  },
};
