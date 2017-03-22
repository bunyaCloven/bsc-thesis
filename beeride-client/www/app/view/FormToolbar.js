Ext.define('Beeride.view.FormToolbar', {
  extend : 'Ext.Toolbar',
  xtype : 'formtoolbar',
  config : {
    items : [ {
      xtype : 'spacer'
    }, {
      iconCls : 'action',
      itemId : 'submit',
      handler : function() {
        this.up('formpanel').submit({
          params : {
            username : Beeride.util.Auth.getUsername()
          },
          failure : function(form, result) {
            if (result.status / 100 === 2) {
              this.up().remove(this);
            }
          }
        });
      }
    }, {
      xtype : 'spacer'
    } ]
  }
});
