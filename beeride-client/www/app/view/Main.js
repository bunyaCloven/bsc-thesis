Ext.define('Beeride.view.Main', {
  extend : 'Ext.navigation.View',
  xtype : 'main',
  config : {
    ui : 'plain',
    navigationBar : {
      docked : 'top',
      items : [
          {
            xtype : 'togglefield',
            id : 'usertypetoggle',
            width : '5.6em',
            border : 0,
            align : 'right',
            // FIXME: make positive and negative views properly isolated
            positiveView : {
              xtype : 'panel',
              layout : 'vbox',
              items : [ {
                flex : 1,
                xtype : 'button',
                itemId : 'path',
                text : 'Path module',
                store : 'Path',
                deleteUrl : '/paths/delete',
                editUrl : '/paths'
              }, {
                flex : 1,
                xtype : 'button',
                itemId : 'car',
                text : 'My Car Profiles',
                store : 'Car',
                deleteUrl : '/cars/delete',
                editUrl : '/cars'
              }, {
                flex : 1,
                xtype : 'button',
                itemId : 'carpool',
                text : 'My Carpools',
                store : 'Carpool',
                listCallback : 'Beeride.view.DriverCarpool',
                deleteUrl : '/carpools/delete',
                doubleClickLoad : '/carpools/driverView',
                editUrl : '/carpools'
              } ]
            },
            negativeView : {
              xtype : 'panel',
              layout : 'vbox',
              items : [ {
                flex : 1,
                xtype : 'button',
                itemId : 'cars',
                text : 'Car Profiles',
                store : 'Cars',
                listCallback : 'Beeride.view.Car',
                editUrl : '/cars',
                paging : true,
                dni : true
              }, {
                flex : 1,
                xtype : 'button',
                itemId : 'carpools',
                text : 'All Carpools',
                store : 'Carpools',
                listCallback : 'Beeride.view.Carpool',
                doubleClickLoad : '/carpools',
                search : true,
                searchPage : 'Beeride.view.CarpoolFilter',
                paging : true,
                dni : true
              }, {
                flex : 1,
                xtype : 'button',
                itemId : 'seats',
                text : 'My Carpools',
                store : 'Seats',
                listCallback : 'Beeride.view.Seat',
                doubleClickLoad : '/seats',
                paging : true,
                dni : true
              } ]
            },
            listeners : {
              change : function(button, newValue) {
                var main = Ext.ComponentQuery.query('main')[0];
                main.removeAll();
                main.getNavigationBar().backButtonStack = [];
                // FIXME: override to add resetting
                main.setItems(newValue ? button.positiveView
                    : button.negativeView);
              },
              painted : function(button) {
                // FIXME: this is copied, find a DRY solution with change event
                var main = Ext.ComponentQuery.query('main')[0];
                main.setItems(this.getValue() ? this.positiveView
                    : this.negativeView);
              }
            }
          }, {
            xtype : 'button',
            text : 'Log Off',
            itemId : 'logOff',
            align : 'right'
          } ]
    }
  }

});
