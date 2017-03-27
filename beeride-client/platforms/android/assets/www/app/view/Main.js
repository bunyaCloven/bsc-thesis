Ext.define('Beeride.view.Main', {
  extend : 'Ext.navigation.View',
  xtype : 'main',
  config : {
    ui : 'plain',
    navigationBar : {
      docked : 'top',
      items : [ {
        xtype : 'togglefield',
        id : 'usertypetoggle',
        width : '5.6em',
        border : 0,
        align : 'right'
      }, {
        xtype : 'button',
        text : 'Log Off',
        itemId : 'logOff',
        align : 'right'
      } ]
    },
    items : {
      xtype : 'menu'
    }
  }
});
