package org.grmeteor

import grails.rest.Resource

@Resource(uri='/Todo')
class Todo {
  String description
  boolean done
}
