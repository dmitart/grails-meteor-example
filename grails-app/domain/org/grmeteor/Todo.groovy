package org.grmeteor

import grails.rest.Resource

@Resource(uri='/todos')
class Todo {
  String description
  boolean done

  static constraints = {
  }

}
