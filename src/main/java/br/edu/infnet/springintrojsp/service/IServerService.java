package br.edu.infnet.springintrojsp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.springintrojsp.model.Message;
import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.model.TextChannel;

@FeignClient(url = "localhost:8081/api/v1", name = "IServerService")
public interface IServerService {

    // @GetMapping("/guilds/{serverid}")
    // public Server getGuildById(@PathVariable(name = "serverid") String serverid);

    @PostMapping("/guilds/{serverid}/join")
    public Server joinGuild(@PathVariable(name = "serverid") String serverid, @RequestParam("id") String id);

    @GetMapping("/channels/{channelid}/messages")
    public TextChannel getTextChannelMessages(@PathVariable(name = "channelid") String channelid);

    @PostMapping("/channels/{channelid}/messages")
    public Message createMessage(@PathVariable(name = "channelid") String channelid,
            @RequestParam(name = "senderid") String senderid, @RequestParam(name = "content") String content);

    @PostMapping("/guilds")
    public Server createGuild(@RequestParam("name") String name, @RequestParam("id") String id);

}
