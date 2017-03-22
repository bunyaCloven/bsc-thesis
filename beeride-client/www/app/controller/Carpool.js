Ext.define('Beeride.controller.Carpool', {
  extend : 'Ext.app.Controller',
  config : {
    control : {
      'button#carpoolsign' : {
        tap : 'sign'
      }
    }
  },
  sign : function(that, e, eOpts) {
    var form = that.up('formpanel');
    form.setBaseParams({
      username : Beeride.util.Auth.getUsername()
    });
    form.submit({
      failure : function(form, result) {
        if (result.status / 100 === 2) {
          form.up().remove(form);
        } else {
          Ext.Msg.alert("", result.message);
        }
      }
    });
  }
});
