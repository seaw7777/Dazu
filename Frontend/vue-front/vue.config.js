const path = require('path');
module.exports = {
  devServer: {
    overlay: false,
    host: '0.0.0.0',
    hot: true,
    disableHostCheck: true,
    historyApiFallback: true,
  },

  css: {
    loaderOptions: {
      sass: {
        sassOptions: {
          includePaths: [path.resolve(__dirname, 'src/')],
          indentedSyntax: true,
        },
        prependData: '@import "~@/assets/sass/_hero.scss"',
      },
    },
  },
  assetsDir: '@/assets/',
  configureWebpack: {},
  transpileDependencies: ['vuetify', 'quasar'],
  pluginOptions: {
    quasar: {
      importStrategy: 'kebab',
      rtlSupport: false,
    },
  },
};
