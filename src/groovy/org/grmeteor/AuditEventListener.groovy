package org.grmeteor

import org.hibernate.event.PostDeleteEvent
import org.hibernate.event.PostDeleteEventListener
import org.hibernate.event.PostInsertEvent
import org.hibernate.event.PostInsertEventListener
import org.hibernate.event.PostUpdateEvent
import org.hibernate.event.PostUpdateEventListener

class AuditEventListener implements PostInsertEventListener, PostDeleteEventListener, PostUpdateEventListener {
  def brokerMessagingTemplate

  @Override
  void onPostDelete(PostDeleteEvent postDeleteEvent) {
    brokerMessagingTemplate.convertAndSend "/topic/todo", "update"
  }

  @Override
  void onPostInsert(PostInsertEvent postInsertEvent) {
    brokerMessagingTemplate.convertAndSend "/topic/todo", "update"
  }

  @Override
  void onPostUpdate(PostUpdateEvent postUpdateEvent) {
    brokerMessagingTemplate.convertAndSend "/topic/todo", "update"
  }
}
