Ext.define('Beeride.view.Map', {
  extend : 'Ext.Panel',
  xtype : 'xmap',
  config : {
    layout : 'vbox',
    items : [ {
      xtype : 'panel',
      layout : 'hbox',
      items : [ {
        xtype : 'textfield',
        name : 'start',
        placeHolder : 'search',
        flex : 1
      }, {
        xtype : 'button',
        iconCls : 'search',
        itemId : 'locationSearch',
        handler : function() {
          var that = this;
          var value = this.up().down('textfield').getValue();
          var geocoder = new google.maps.Geocoder();
          var map = that.up('xmap').down('map');
          geocoder.geocode({
            address : value
          }, function(result, status) {
            if (status !== "OK") {
              Ext.Msg.alert("", "No location found.");
            } else {
              var location = result[0].geometry.location;
              map.setMapCenter({
                latitude : location.lat(),
                longitude : location.lng()
              });
            }
          });
        }
      } ]
    }, {
      xtype : 'map',
      itemId : 'map',
      flex : 1
    }, {
      xtype : 'locationtoolbar'
    } ]
  }
});
