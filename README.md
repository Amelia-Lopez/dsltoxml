Groovy DSL to XML Converter
===========================

This application automatically converts a DSL written in Groovy to an XML document.

Basic Example
=============

Sample Input
------------
```
'e-mail' {
    from 'you@place.com'
    to 'someone@somewhere.com'
    subject 'Orders'
    body (style: 'html') {
        p 'Attack at dawn.'
    }
}
```

Sample Output
-------------
```
<e-mail>
  <from>you@place.com</from>
  <to>someone@somewhere.com</to>
  <subject>Orders</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
```

Variable Binding Example
========================

Sample Input
------------
```
'e-mail' {
    from user
    to 'someone@somewhere.com'
    subject 'Orders'
    body (style: defaultStyle ? 'html' : bodyStyle) {
        p 'Attack at dawn.'
    }
}
```

With code bindings:
`[user: 'me@here.com', defaultStyle: true]`

Sample Output
-------------
```
<e-mail>
  <from>me@here.com</from>
  <to>someone@somewhere.com</to>
  <subject>Orders</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
```

Templating Example
==================

Sample Input
------------
```
[[address: 'bbobby@somewhere.com', name: 'Bob Bobby'],
 [address: 'ttimmy@somewhere.com', name: 'Tim Timmy'],
 [address: 'deepthroat@nowhere.com'],
 [address: 'secret@nowhere.com']].each { destination ->
    'e-mail' {
        from 'me@somewhere.com'
        to destination.address
        subject "Orders for ${destination.name ?: 'You'}"
        body (style: 'html') {
            p 'Attack at dawn.'
        }
    }
}
```

Sample Output
-------------
```
<e-mail>
  <from>me@somewhere.com</from>
  <to>bbobby@somewhere.com</to>
  <subject>Orders for Bob Bobby</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
<e-mail>
  <from>me@somewhere.com</from>
  <to>ttimmy@somewhere.com</to>
  <subject>Orders for Tim Timmy</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
<e-mail>
  <from>me@somewhere.com</from>
  <to>deepthroat@nowhere.com</to>
  <subject>Orders for You</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
<e-mail>
  <from>me@somewhere.com</from>
  <to>secret@nowhere.com</to>
  <subject>Orders for You</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
```