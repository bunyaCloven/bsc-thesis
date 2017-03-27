function loginCallback(form, result) {
  if (result.status / 100 === 2) {
    Ext.Viewport.removeAll();
    Ext.Viewport.add({
      xtype : 'main'
    });
    var mainView = Ext.ComponentQuery.query('main')[0];
    mainView.getLayout().setAnimation(false);
    var store = Ext.data.StoreManager.lookup('Path');
    var proxy = store.getProxy();
    proxy.setExtraParam('username', Beeride.util.Auth.getUsername());
    var loaded = store.load();
    var store2 = Ext.data.StoreManager.lookup('Car');
    var proxy2 = store2.getProxy();
    proxy2.setExtraParam('username', Beeride.util.Auth.getUsername());
    var loaded = store2.load();
  } else {
    Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
  }
};

Ext.define('Beeride.controller.Login', {
  extend : 'Ext.app.Controller',
  requires : 'Ext.Map',
  config : {
    refs : {
      main : 'main'
    },
    control : {
      'button#login' : {
        tap : 'login'
      },
      'button#logOff' : {
        tap : 'logoff'
      },
      'button#signup' : {
        tap : 'signup'
      }
    }
  },
  login : function(that, e, eOpts) {
    var username = that.up().down('#username').getValue();
    var password = that.up().down('#password').getValue();
    if (username.length === 0 || password.length === 0) {
      Ext.Msg.alert('', 'You need to enter something', Ext.emptyFn);
      return;
    }
    that.up('formpanel').setMasked({
      xtype : 'loadmask',
      message : 'Signing In...'
    });
    Beeride.util.Auth.set(username, password);
    that.up('formpanel').submit({
      headers : {
        Authorization : Beeride.util.Auth.get()
      },
      url : serverAddress + '/login',
      method : 'POST',
      params : {
        username : username,
        password : password
      },
      success : loginCallback,
      failure : loginCallback
    });
  },
  logoff : function() {
    Ext.Ajax.request({
      url : serverAddress + '/logout',
      success : function() {
        Ext.Viewport.removeAll();
        Ext.Viewport.add({
          xtype : 'login'
        });
      }
    });

  },
  signup : function() {
    Ext.Viewport.removeAll();
    Ext.Viewport.add({
      xtype : 'signup'
    });
  }
});
