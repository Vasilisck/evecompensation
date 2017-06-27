package models

import java.util.Date

/**
  * Created by vasilisck on 6/27/17.
  */
case class Killmail(killmail_id: Long,
                    killmail_time: Date,
                    victim: Victim,
                    attackers: List[Attacker],
                    solar_system_id: Long)

case class Attacker(security_status: Float,
                    final_blow: Boolean,
                    damage_done: Int,
                    faction_id: Option[Long],
                    character_id: Option[Long],
                    corporation_id: Option[Long],
                    alliance_id: Option[Long],
                    ship_type_id: Long,
                    weapon_type_id: Option[Long])

case class Victim(damage_taken: Long,
                  ship_type_id: Long,
                  character_id: Long,
                  corporation_id: Long,
                  alliance_id: Long,
                  items: List[Item],
                  position: Position
                 )

case class Item(item_type_id: Long,
                singleton: Long,
                flag: Int,
                quantity_destroyed: Option[Int],
                quantity_dropped: Option[Int])

case class Position(x: Double, y: Double, z: Double)

