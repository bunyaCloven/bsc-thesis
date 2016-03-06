Ext.define('Beeride.controller.Carpool', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'button#carpoolsign' : {
				tap : 'sign'
			},
		}
	},
	sign : function(that, e, eOpts) {
		var form = that.up('formpanel');
		form.setBaseParams({
			username : Beeride.util.Auth.getUsername()
		});
		form.submit({
			success : function() {
				form.up().remove(form);
			},
			failure : function(that, result) {
				Ext.Msg.alert("", result.message);
			}
		});
	}
});