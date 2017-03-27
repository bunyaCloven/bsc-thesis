Ext.define('Beeride.store.Car', {
  extend : 'Ext.data.Store',
  config : {
    model : 'Beeride.model.Car',
    proxy : {
      headers : {
        Authorization : Beeride.util.Auth.get()
      },
      extraParams : {},
      type : 'ajax',
      url : serverAddress + "/cars",
      reader : {
        type : "json",
      // rootProperty : "data"
      }
    },
    autoLoad : false
  }
});
